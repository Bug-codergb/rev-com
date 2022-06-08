import styled from "styled-components";
export const ToplistItemWrapper = styled.div`
  .toplist-name{
    font-size: 26px;
    color:#494949;
    font-weight: bolder;
  }
  .movies {
    & > li {
      border-top: 1px dotted #dddddd;
      padding: 10px 0;
      display: flex;
      align-items: flex-start;
      .img-container {
        width: 75px;
        height: 108px;
        overflow: hidden;
        position: relative;
        cursor: pointer;
        img {
          position: absolute;
          left: 50%;
          top: 50%;
          transform: translate(-50%, -50%);
          width: 100%;
        }
      }
      .right-msg{
        margin: 0 0 0 20px;
        .movie-name{
          cursor: pointer;
          &>span{
            font-size: 14px;
            color: #3377AA;
          }
        }
        .info{
          color: #666;
          font-size: 13px;
          margin: 5px 0 0 0;
          &>span{
            color: #666;
            font-size: 13px;
          }
        }
        .rate{
          display: flex;
          align-items: center;
          .rate-movie{
            display: flex;
            align-items: center;
            &>li{
              margin: 0 4px 0 0;
            }
          }
          .score{
            color: #e09015;
            font-size: 13px;
            margin: 0 0 0 4px;
          }
          .comment-count{
            color: #666666;
            font-size: 13px;
            margin: 0 0 0 10px;
          }
        }
      }
    }
  }
`
