CREATE TABLE clientTransactions
(
    omnibusTransactionId varchar(24) NOT NULL,
    Long actualPostingDate integer, 
    String agentForFirm varchar(100),
    PRIMARY KEY (omnibusTransactionId)
);