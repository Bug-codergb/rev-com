export function debounce(fn: any, time: number, immediate: boolean) {
  let t: any = null
  const debounced: any = function () {
    // @ts-ignore
    // eslint-disable-next-line @typescript-eslint/no-this-alias
    const self = this
    const args = arguments
    if (t) {
      clearTimeout(t)
    }

    if (immediate) {
      const exec = !t
      t = setTimeout(() => {
        t = null
      }, time)

      if (exec) fn.apply(self, args)
    } else {
      t = setTimeout(() => {
        fn.apply(self, args)
      }, time)
    }
  }
  debounced.remove = function () {
    clearTimeout(t)
    t = null
  }
  return debounced
}
