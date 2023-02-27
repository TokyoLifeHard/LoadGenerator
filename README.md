# LoadGenerator
## Описание
Это pet - проект генератора нагрузки.
Описание нагрузки происходит посредством описания yaml файла.  
Например:  
steps:
- http:
  url: http://www.boredapi.com/api/activity
  metod: GET
  agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0
- http:
  url: https://animechan.vercel.app/api/random
  metod: GET
  agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0
- jdbc:
  database: mysql
  host: localhost
  port: 3306
  username: test
  password: test
  name: test
  query: select * from test
