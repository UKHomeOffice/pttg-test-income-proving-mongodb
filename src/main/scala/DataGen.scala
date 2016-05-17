import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object DataGen {

  def main(args: Array[String]): Unit = {

    val title = args(0)
    val forename = args(1)
    val surname = args(2)
    val nino = args(3)
    val payFreq = args(4)
    val raisedDate = new SimpleDateFormat("yyyy-MM-dd").parse(args(5))
    val amount = args(6)
    val entries = args(7).toInt
    val employer = args(8)

    val application = Application(title, forename, surname, nino)
    val incomes = buildIncomes(raisedDate, entries, payFreq == "W1", amount, employer)
    val applicant = Applicant(forename, surname, nino, payFreq, Incomes(incomes) )

    writeToFiles(applicant, application)

  }

  def buildIncomes(raisedDate: Date, entries: Int, weekly: Boolean = true, amount: String, employer: String) = {
    0 until entries map { entry =>
      Income(formatDate(subtractDateAmount(raisedDate, entry, weekly )), employer, amount)
    }
  }

  private def subtractDateAmount(date: Date, num: Int, weekly: Boolean = true): Date = {
    val calendar = Calendar.getInstance
    calendar.setTime(date)
    weekly match {
      case true => calendar.add (Calendar.DATE, -num * 7)
      case false =>calendar.add (Calendar.MONTH, -num )
    }
    calendar.getTime
  }

  def formatDate(date: Date) = {
    new SimpleDateFormat("dd/MM/yyyy").format(date)
  }

  def writeToFiles(applicant: Applicant, application: Application) = {
    new PrintWriter(s"income-proving-mongodb/src/main/resources/applicant_generated_${applicant.nino}.json") { write(applicant.toString()); close }
    new PrintWriter(s"income-proving-mongodb/src/main/resources/application_generated_${application.nino}.json") { write(application.toString()); close }
  }

}