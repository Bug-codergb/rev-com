function pathMapMenu(menu: any[], currentPath: string): any {
  for (const item of menu) {
    if (item.children && item.children.length !== 0) {
      for (const it of item.children) {
        if (it.path === currentPath) {
          return it
        }
      }
    }
  }
}
export default pathMapMenu
