
# zinworks

Hi,
Thank you for this assignment and i hope that you enjoy my project,

My project is based on:
* Java
* Spring
* Microservices (controllers)
* architecture design in that it has
  * controllers
  * services
  * repositories
  * model
  * exceptions
  * utils
* I feel when producing a project one should have extensibility in mind
* The testing programs that were used were:
  * JUnit
  * Mockito
  * Assertions
* (I am avid about having 100% Unit test coverage in any project that i do and this project is the same - 100% unit test coverage on both class and method level of 100% unit test coverage)
* My ATM system solution is 100% unit test coverage as other projects that i am involved in
* I have tested all scenarios that were outlined within the Requirements specification - PLUS i have produced 100% unit test coverage and also integrated a statistics API
* The statistics API could be extendDised/included for other items but these are just items that i see are needed for now
* i also introduced a logging system so we can keep track of the flow of customers interactions with the ATM system

API methods
* There are 3 API methods currently available within the system:
  * Balance: <>/customer/balance - as i thwith query parameters "accountNumber" and "pin"
  * Dispense: <>/customer/dispenseAccount - with query parameters "accountNumber" and "pin" and "amountRequested"
  * StatisticsL <>/statistics/getStatistics - no query parameters

Docker:
*  The dockerfie is contained within "docker" within the root directory

Documentation
* notesToDo.txt (in "doc" in root directory)
  * i used this to write down my ideas as i programmed the system and used it in a way as in a JIRA dashboard for keeping track of items to do
  * those that were done have a - to the left of them and a () to the right of them
* newIdeas.txt
  * as i developed the ATM system i was thinking about the overall project requirements for the ATM system to put into JIRA and to keep track of
  * there are 2 sections within "newIdeas.txt"
    * 1 - for business/product owners to think about too about how to extend the ATM system - items such as
      * add the ability for a new user to be added into the ATM system
      * ability for an existing user to update their PIN only if they have their old PIN (for this ATM system) or we have their email address etc.
      * allow an existing user to add money into their account and hence ATM
    * 2 - IT technical items
      * such as using annotations to check if its a real customer prior to getting into the controller layer
      * examine if thread local can be used for tracking customers

Notes:
* Database - i do see that a DB could be integrated for both processing and for locking updates to be done to the ATM balance
* A webpage would be useful for reproducing requests and responses - what i mainly used was Postman
* Postman - i have included the Postman collection that i used for all 3 API methods and for error producing within folder //doc//postman_collection//ZinWorks.postman_collection.json

If i could say:
* Hope you had a Great Weekend
* I really enjoyed developing this ATM system
* if you need any queries or update or questions please feel free to contact me on 0872079574,

I Look forward to all and any feedback,

Thanks,
Niall