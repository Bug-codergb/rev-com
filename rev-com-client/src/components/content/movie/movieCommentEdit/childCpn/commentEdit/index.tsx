import React, {memo, FC, ReactElement, FormEvent, useState, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import {message, Rate} from "antd";
import '@wangeditor/editor/dist/css/style.css';
import { Editor, Toolbar } from '@wangeditor/editor-for-react'
import { IDomEditor, IEditorConfig } from '@wangeditor/editor'
import {
  CommentEditWrapper
}from "./style";

import {HOST_NAME} from "../../../../../../constant/host";
import localCache from "../../../../../../utils/cache"
import {publishComment} from "../../../../../../network/comment";
interface IProps{
  id:string
}
const CommentEdit:FC<IProps>=(props):ReactElement=>{
  const {id}=props;
  const navigate=useNavigate();
  const [editor, setEditor] = useState<IDomEditor | null>(null)
  const [html, setHtml] = useState('');
  const [title,setTitle]=useState<string>('');
  const [commentId,setCommentId]=useState<string>(`${new Date().getTime()}`);
  const [success,setSuccess]=useState<boolean>(false);
  const [score,setScore]=useState<number>(0)
  useEffect(()=>{
    return ()=>{
      editor?.destroy();
    }
  },[])
  const toolbarConfig = {
    excludeKeys: [
      "insertVideo",
      "uploadVideo"
    ]
  }
  const editorConfig: Partial<IEditorConfig> = {
    placeholder: '请输入影评内容...',
    MENU_CONF:{}
  }
  if(editorConfig && editorConfig.MENU_CONF){
    editorConfig.MENU_CONF['uploadImage']={
      server: `${HOST_NAME}/comment/upload/${commentId}`,
      timeout: 5 * 1000,
      fieldName: 'picture',
      headers: {
        Authorization: localCache.getCache("userMsg").token,
      },
    }
    editorConfig.MENU_CONF['insertImage'] = {
      onInsertedImage(imageNode: any | null) {
        if (imageNode == null) return
        console.log(imageNode)
      },
    }
  }
  console.log(editor?.getMenuConfig('fontSize'))
  const titleInp=(e:FormEvent<HTMLInputElement>)=>{
    setTitle(e.currentTarget.value)
  }
  const rateChange=(e:number)=>{
    setScore(e)
  }
  const publish=async ()=>{
    if(title.trim().length===0){
      message.warn({
        content:"影评标题不能为空",
        className:"global-tip",
      })
    }else if(html.trim().length===0 || html==="<p><br></p>"){
      message.warn({
        content:"请输入影评内容",
        className:"global-tip",
      })
    }else {
      const data=await publishComment(commentId,html,"movieId",id,1,title,score);
      if(data.status===200){
        message.success({
          content:"影评发表成功",
          className:"global-tip",
        })
        navigate("/Home/Movie/movieDetail",{
          replace:true,
          state:{
            id:id
          }
        })
      }
    }
  }
  return (
    <CommentEditWrapper>
      <div className="score">
        <Rate className="rate-style"
              allowClear={false}
              value={score}
              onChange={e=>rateChange(e)}/>
      </div>
      <div className="comment-pub">
        <input type="text" className="comment-title" placeholder="添加影评标题" maxLength={60} onInput={(e)=>titleInp(e)}/>
      </div>
      <Toolbar
        editor={editor}
        defaultConfig={toolbarConfig}
        mode="default"
        style={{ borderBottom: '1px solid #ccc' ,width:"1000px",margin:"0 auto"}}
      />
      <Editor
        defaultConfig={editorConfig}
        value={html}
        onCreated={setEditor}
        onChange={editor => setHtml(editor.getHtml())}
        mode="default"
        style={{borderBottom: '1px solid #ccc',
                height: '450px', overflowY: 'hidden',width:"1000px",margin:"0 auto"}}
      />
      <div className="control-btn">
        <button onClick={e=>publish()}>发布</button>
      </div>
    </CommentEditWrapper>
  )
}
export default memo(CommentEdit);
