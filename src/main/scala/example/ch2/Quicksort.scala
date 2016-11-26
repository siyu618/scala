package example.ch2

/**
 * Created by tianyuzhi on 16/10/27.
 */
class Quicksort {
  def sort(xs: Array[Int]): Unit = {
    def swap(i:Int, j:Int): Unit = {
      val tmp = xs(i); xs(i) = xs(j); xs(j) = tmp
    }

    def sort1(l:Int, r:Int): Unit = {
      val pivot = xs((l+r)/2)
      var i = l
      var j = r
      while (i <= j) {
        while(xs(i) < pivot) i += 1
        while(xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (i < r) sort1(j, r)
    }

    sort1(0, xs.length-1)
  }
}
