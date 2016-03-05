

import org.scalatest.Assertions
import org.scalacheck.Test
import org.junit.Test
import org.example.JavaVersion
import org.example.JavaVersion.JAVA_1_8
import org.example.JavaVersion.JAVA_0_9
import org.example.JavaVersion.JAVA_1_7
import org.example.JavaVersion.JAVA_1_4
import org.example.JavaVersion.JAVA_RECENT

class JavaVersionTest extends Assertions {

  @Test
  def getJava1_8() = {
    val java1_8 = JAVA_1_8
    assert(java1_8 == JAVA_1_8)
  }

  @Test
  def 文字列からJavaVersionを取り出す = {
    val java1_7 = JavaVersion.get("1.7")
    assert(java1_7.get == JAVA_1_7)
  }

  @Test
  def 存在しないバージョンを探してnullが返る = {
    val noneOfJavaVersion = JavaVersion.get("3.0")
    assert(noneOfJavaVersion.isEmpty)
  }

  @Test
  def atLeastメソッドで1_4と1_8を比較する = {
    val java1_4 = JAVA_1_4
    val java1_8 = JAVA_1_8
    assert(java1_8.atLeast(java1_4))
  }

  @Test
  def JAVA_RECENTで1_8になる = {
    val javaRecent = JAVA_RECENT
    assert(JAVA_RECENT.name == JAVA_1_8.name)
  }

}