case class Incomes(incomes: Seq[Income]) {
  override def toString() = {

    "[" + incomes.mkString(",") + "]"

  }
}

case class Income(payDate: String, employer: String, income: String) {
  override def toString() = {
    s"""{
      "payDate" : "$payDate",
      "employer" : "$employer",
      "income" : "$income"
    }"""
  }
}

case class Application(title: String, forename: String, surname: String, nino: String) {
  override def toString() = {
    s"""{
       "individual": {
         "title": "$title",
         "forename": "$forename",
         "surname": "$surname",
         "nino": "$nino"
       }
     }"""
  }
}

case class Applicant(forename: String, surname: String, nino: String, payFreq: String, incomes: Incomes) {
  override def toString() = {
    s"""{
       "individual" : {
          "forename" : "$forename",
          "surname" : "$surname",
          "nino" : "$nino"
        },
         "payFreq": "$payFreq",
        "incomes" : $incomes
      }"""
  }
}
