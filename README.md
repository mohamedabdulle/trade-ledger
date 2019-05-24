# subaccounting

## MongoDB

Start mongod process with 2 commands:

Substitute {PATH} with your absolute path.

mongod --port 12345 --directoryperdb --dbpath {PATH}\subaccounting\src\main\resources\mongodb\data\db --logpath C:\data\log\mongo.log --logappend

mongo --port 12345

Confirm correct directory and port number:

db.serverCmdLineOpts()

## Lombok

Setting up Lombok:

https://www.baeldung.com/lombok-ide