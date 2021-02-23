package example

import zio.{ExitCode, URIO, ZIO}
import zio.console._

import java.io.IOException

object Hello extends Greeting with zio.App {
  def run(args: List[String]): URIO[Console, ExitCode] = myAppLogic.exitCode

  val myAppLogic: ZIO[Console, IOException, Unit] = for {
    _ <- putStrLn("Hello, what's your name?")
    name <- getStrLn
    _ <- putStrLn(s"$greeting, $name, welcome to ZIO")
  } yield ()

}

trait Greeting {
  lazy val greeting: String = "hello"
}
