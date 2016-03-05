package org.example

sealed abstract class JavaVersion(val value:Float, val name:String) {
  def atLeast(requiredVersion:JavaVersion) = {
		value >= requiredVersion.value
  }
}

object JavaVersion {

  case object JAVA_0_9 extends JavaVersion(1.5f,"0.9")
  case object JAVA_1_1 extends JavaVersion(1.1f,"1.1")
  case object JAVA_1_2 extends JavaVersion(1.2f,"1.2")
  case object JAVA_1_3 extends JavaVersion(1.3f,"1.3")
  case object JAVA_1_4 extends JavaVersion(1.4f,"1.4")
  case object JAVA_1_5 extends JavaVersion(1.5f,"1.5")
  case object JAVA_1_6 extends JavaVersion(1.6f,"1.7")
  case object JAVA_1_7 extends JavaVersion(1.7f,"1.7")
  case object JAVA_1_8 extends JavaVersion(1.8f,"1.8")
  case object JAVA_1_9 extends JavaVersion(1.9f,"1.9")
  case object JAVA_RECENT extends JavaVersion(maxVersion, maxVersion.toString())

  def getJavaVersion(nom:String) = get(nom)

  def get(nom:String):Option[JavaVersion] = {
    nom match {
      case "0.9" => Some(JAVA_0_9)
      case "1.1" => Some(JAVA_1_1)
      case "1.2" => Some(JAVA_1_2)
      case "1.3" => Some(JAVA_1_3)
      case "1.4" => Some(JAVA_1_4)
      case "1.5" => Some(JAVA_1_5)
      case "1.6" => Some(JAVA_1_6)
      case "1.7" => Some(JAVA_1_7)
      case "1.8" => Some(JAVA_1_8)
      case "1.9" => Some(JAVA_1_9)
      case _ => None
    }
  }

  private def maxVersion():Float = {
    val v = toFloatVersion(System.getProperty("java.version", "2.0"))
    if(v > 0) v else 2f
  }

  private def toFloatVersion(value:String): Float = {
    try {
    	val toParse = value.split("\\.")
    	(toParse.apply(0) + "." + toParse.apply(1).charAt(0).toString()).toFloat
    } catch {
      case e:Exception => -1
    }
  }

}