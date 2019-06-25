DROP TABLE IF EXISTS ClientTransaction;
CREATE TABLE ClientTransaction
(
    ClientTransactionId SERIAL PRIMARY KEY,
    ActualPostingDate timestamptz,
    AgentForFirm varchar(50),
    AnticipatedPostingDate timestamptz,
    Bin varchar(50),
    Branch varchar(50),
    ClearingFirmNumber int,
    CountryCode varchar(50),
    CurrencyIndicator varchar(50),
    DealerFirmNumber int,
    EffectOnBalance varchar(50),
    Fund_id varchar(50),
    MoneyAmount varchar(50),
    OmnibusTransaction_Id varchar(50),
    Price float,
    RepresentativeName varchar(50),
    RepresentativeNumber int,
    SecurityId varchar(50),
    SequenceId varchar(50),
    ShareQuantity varchar(50),
    StateOfSale varchar(50),
    SubmissionDate timestamptz,
    Symbol varchar(50),
    TradeDate timestamptz,
    TransactionCategory varchar(50),
    TransactionSource varchar(50),
    TransactionStatus varchar(50),
    TransactionSubType varchar(50),
    TransactionType varchar(50),
    TransactionUserId varchar(50)
);

DROP TABLE IF EXISTS Comment;
CREATE TABLE Comment
(
    CommendId SERIAL PRIMARY KEY,
    CommentText varchar(50),
    CommentDateTime timestamptz,
    CommentUserId varchar(50)
);

DROP TABLE IF EXISTS DistributionTransaction;
CREATE TABLE DistributionTransaction
(
    DistributionTransactionId SERIAL PRIMARY KEY,
    Aggregated boolean,
    DistributionEventType varchar(50),
    DistributionRate varchar(50),
    DistributionRecordDate timestamptz,
    EventId int,
    ExcludedFromAggregation boolean,
    OmnibusTradeTransmitted boolean
);

DROP TABLE IF EXISTS Event;
CREATE TABLE Event
(
    EventRowId SERIAL PRIMARY KEY,
    EventIdValue int
);
INSERT INTO ClientTransaction (ActualPostingDate, AgentForFirm)
VALUES (NOW(), 'DST');
SELECT * from clienttransaction;