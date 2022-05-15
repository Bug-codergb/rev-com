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
      }
    ]
  },
  {
    name: "小说管理",
    icon: "notebook",
    index: "2"
  },
  {
    name: "音乐管理",
    icon: "mic",
    index: "3"
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
