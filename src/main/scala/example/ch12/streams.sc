
Stream.range(1,10).filter(x => x % 3 == 0).sum
// lazy initialization
Stream.cons(1, Stream.cons(2, Stream.Empty))

