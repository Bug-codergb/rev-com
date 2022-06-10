const menu = [
  {
    name: "电影管理",
    icon: "film",
    index: "1",
    children: [
      {
        index: "1001",
        name: "电影信息",
        path: "/Home/Movie/video"
      },
      {
        index: "1002",
        name: "导演信息",
        path: "/Home/Movie/director"
      },
      {
        index: "1003",
        name: "演员信息",
        path: "/Home/Movie/actor"
      },
      {
        index: "1004",
        name: "编剧信息",
        path: "/Home/Movie/screenwriter"
      },
      {
        index: "1005",
        name: "小组信息",
        path: "/Home/Movie/group"
      }
    ]
  },
  {
    name: "小说管理",
    icon: "notebook",
    index: "2",
    children: [
      {
        index: "2001",
        name: "图书信息",
        path: "/Home/Book/books"
      },
      {
        index: "2002",
        name: "作家信息",
        path: "/Home/Book/writer"
      },
      {
        index: "2003",
        name: "出版社信息",
        path: "/Home/Book/publish"
      }
    ]
  },
  {
    name: "音乐管理",
    icon: "mic",
    index: "3",
    children: [
      {
        index: "3003",
        name: "歌手信息",
        path: "/Home/Music/artist"
      }
    ]
  },
  {
    name: "用户管理",
    icon: "user",
    index: "4"
  },
  {
    name: "设置",
    icon: "setting",
    index: "5"
  }
]
export { menu }
