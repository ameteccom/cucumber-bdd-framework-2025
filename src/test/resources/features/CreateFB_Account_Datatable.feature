Feature: New facebook accounts

  @demo-datatable
  Scenario: Create multiple new accounts in Facebook
    Given I open Facebook URL and Create account with below information
      | First Name | Last Name | Email Address | Password | Phone Number | DOB        |
      | Jack       | Sparrow   | JS@test.com   | 1234     | 2224445678   | 1/1/1990   |
      | John       | Dow       | JS@test.com   | 5678     | 3334448907   | 10/02/1989 |
      | Bili       | Chain     | BC@test.com   | 0987     | 1234567899   | 11/03/2005 |
