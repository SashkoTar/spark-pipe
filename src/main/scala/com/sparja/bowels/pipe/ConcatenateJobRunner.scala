package com.sparja.bowels.pipe

import org.apache.spark.{SparkConf, SparkContext}

object ConcatenateJobRunner {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Concatenate Script")
    val sc = new SparkContext(conf)
    val data = 1 to 20
    val dataRDD =  sc.makeRDD(data)
    println(s"Input RDD has ${dataRDD.partitions.length} partitions")
    val pipeRDD = dataRDD.pipe("./concatenate.sh")
    println(s"Output RDD has ${pipeRDD.partitions.length} partitions")
    pipeRDD.collect().foreach(println)
  }

}
