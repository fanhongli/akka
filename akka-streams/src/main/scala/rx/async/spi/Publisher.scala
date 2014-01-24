package rx.async.spi

trait Subscription {
  def cancel(): Unit // method name taken from real-world semantics
  def requestMore(elements: Int): Unit
}

trait Publisher[T] {
  def subscribe(subscriber: Subscriber[T]): Unit
}

trait Subscriber[T] {
  def onSubscribe(subscription: Subscription): Unit
  def onNext(element: T): Unit
  def onComplete(): Unit
  def onError(cause: Throwable): Unit
}
