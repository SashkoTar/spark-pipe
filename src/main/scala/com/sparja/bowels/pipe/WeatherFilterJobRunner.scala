package com.sparja.bowels.pipe

import org.apache.spark.{SparkConf, SparkContext}


object WeatherFilterJobRunner {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Filter Script")
    val sc = new SparkContext(conf)

    val dataRDD = sc.textFile("<Replace it with HDFS_CONF_DIR>" + "/weather_yagotyn.csv")

    dataRDD.pipe("sed s/\"//g")
      .pipe(Seq("awk", "-F;", "/^[0-9]/ && $22 < 1 {print $1, $2, $3, $6, $22}")).
      collect().foreach(println)

  }

}
