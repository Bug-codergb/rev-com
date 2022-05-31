import React, {memo, FC, ReactElement, FormEvent, useState, useEffect} from "react";
import '@wangeditor/editor/dist/css/style.css';
import { Editor, Toolbar } from '@wangeditor/editor-for-react'
import { IDomEditor, IEditorConfig } from '@wangeditor/editor'
import {
  CommentEditWrapper
}from "./style";
import {message} from "antd";
import {HOST_NAME} from "../../../../../constant/host";
import localCache from "../../../../../utils/cache"
const CommentEdit:FC=():ReactElement=>{
  const [editor, setEditor] = useState<IDomEditor | null>(null)
  const [html, setHtml] = useState('');
  const [title,setTitle]=useState<string>('');
  const [success,setSuccess]=useState<boolean>(false);
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
      server: `${HOST_NAME}/comment/upload/1654008496646`,
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
  const titleInp=(e:FormEvent<HTMLInputElement>)=>{
    setTitle(e.currentTarget.value)
  }
  const publish=()=>{
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
      console.log(title,html)
    }
  }
  return (
    <CommentEditWrapper>
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
        style={{borderBottom: '1px solid #ccc', height: '450px', overflowY: 'hidden',width:"1000px",margin:"0 auto"}}
      />
      <div className="control-btn">
        <button onClick={e=>publish()}>发布</button>
      </div>
    </CommentEditWrapper>
  )
}
export default memo(CommentEdit);
