# subaccounting

## MongoDB

Export MongoDB before pushing code:

Substitute {PATH} with your absolute path.

mongodump -d subaccounting -o {PATH}\subaccounting\src\main\resources\mongodb\data\db

Import MongoDB after pull:

mongorestore -d subaccounting {PATH}\subaccounting\src\main\resources\mongodb\data\db\subaccounting

Confirm correct directory and port number:

db.serverCmdLineOpts()

## Lombok

Setting up Lombok:

https://www.baeldung.com/lombok-ide