package com.dap.streams.listener

/*
@Author DC
Description: StreamingQueryListener  is a Scala Class to wrap Pythonquerylistener
 */


import org.apache.spark.sql.streaming.StreamingQueryListener
import org.apache.spark.sql.streaming.StreamingQueryListener._

trait PythonObserver {
  def on_next(o: Object): Unit
}

class PythonStreamingQueryListener(observer: PythonObserver)
  extends StreamingQueryListener {
  override def onQueryProgress(event: QueryProgressEvent): Unit = {
    observer.on_next(event)
  }
  override def onQueryStarted(event: QueryStartedEvent): Unit = {println("Start")}
  override def onQueryTerminated(event: QueryTerminatedEvent): Unit = {}
}
