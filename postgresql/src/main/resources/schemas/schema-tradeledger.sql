DROP TABLE IF EXISTS ClientTransaction;
CREATE TABLE ClientTransaction
(
    ClientTransactionId SERIAL PRIMARY KEY,
    ClearingFirmNumber int,
    DealerFirmNumber int,
    AgentForFirm varchar(50),
    Bin varchar(50),
    FundId varchar(50),
    Cusip varchar(50),
    ExchangetoCusip varchar(50),
    NsccControlNumber varchar(50),
    NsccCorrectionIndicator varchar(50),
    CurrencyIndicator varchar(50),
    Price float,
    DistributionEventType varchar(50),
    DistributionRecordDate varchar(50),
    TradeDate varchar(50),
    SubmissionDate varchar(50),
    TransactionRecievedDate varchar(50),
    TransactionRecievedTime varchar(50),
    AnticipatedSettlementDate varchar(50),
    NsccSettlementOverrideReasonCode varchar(50),
    TransactionStatus varchar(50),
    WorkedCd varchar(50),
    PriceProtected varchar(50),
    ContingentDeferredSalesChargeLiquidationIndicator varchar(50),
    LiquidationIndicator529 varchar(50),
    NavReasonCode varchar(50),
    SalesChargeRate float,
    DiscountCategory varchar(50),
    NsccRoaLoiValue varchar(50),
    ActualRoaValueSource varchar(50),
    LoiNumber varchar(50),
    ShortTermRedemptionFeeRate float,
    ShortTermRedemptionFeeShareAmount float,
    ShortTermRedemptionFeeMoneyAmount float,
    ContingentDeferredSalesChargeMoneyAmount float,
    MoneyMarketLiquidityFeeRate float,
    MoneyMarketLiquidtyFeeMoneyAmount float,
    TaxIdNumber varchar(50),
    TaxIdType varchar(50),
    Branch varchar(50),
    RepresentativeName varchar(50),
    RepresentativeNumber int,
    StateOfSale varchar(50),
    CountryCode varchar(50),
    SocialCode varchar(50),
    MoneyMarketLiquidityFeeRedemptionGateIndicator varchar(50),
    MoneyMarketAggregatedOrderIndicator varchar(50),
    DerivedBusinessProcessingGroup varchar(50),
    NsccTransactionType varchar(50),
    NsccTransactionCode varchar(50),
    NsccOriginalControlNumber varchar(50),
    NsccOriginalCorrectionIndicator varchar(50),
    NsccTestIndicator varchar(50),
    NsccAsofIndicator varchar(50),
    AsofReasonCode varchar(50),
    NsccCustomerName varchar(50),
    NsccFundAccountIndicator varchar(50),
    NsccBookPhysicalShareIndicator varchar(50),
    NsccRelatedTradeIndicator varchar(50),
    AssetTypeIndicator varchar(50),
    NsccFractionIndicator varchar(50),
    GrossNetSettlementIndicator varchar(50),
    NsccSecurityIssueType varchar(50),
    NsccFundParticipantNumberCd varchar(50),
    NsccOmnibusAccountIndicatorCd varchar(50),
    NsccProgramTransactionIndicatorCd varchar(50),
    NsccPeriodicFrequencyIndicatorCd varchar(50),
    OrderNumber varchar(50),
    NsccAcatsControlNumber varchar(50),
    NsccAcatsAssetsSequenceId varchar(50),
    FirmRoleInTransfer varchar(50),
    OriginatingFirmNumber varchar(50),
    OriginatingAgentForFirm varchar(50),
    OriginatingBIN varchar(50),
    OriginatingFundAccount varchar(50),
    OriginatingAccountOmnibusIndicator varchar(50),
    DestinationBIN varchar(50),
    DestinationFundAccount varchar(50),
    DestinationAccountOmnibusIndicator varchar(50),
    AsofPaymentDate varchar(50),
    NsccRegistrationStatusCode varchar(50),
    NsccRequestStatusCode varchar(50)
);

DROP TABLE IF EXISTS TransactionDialog;
CREATE TABLE TransactionDialog
(
    TransactionDialogId SERIAL PRIMARY KEY,
    TransmissionReceivedDateTime timestamptz,
    TransmissionId1 varchar(50),
    TransmissionId2 varchar(50),
    TransmissionTransactionId varchar(50),
    DialogSeqNumber varchar(50),
    DialogDirection varchar(50),
    NsccRecordType varchar(50),
    TransmissionRecordType varchar(50),
    UnformattedRecordType varchar(50),
    ShareQuantity float,
    GrossMoneyAmount float,
    NetMoneyAmount float,
    Price float,
    ExchangeToShareQuantity float,
    ExchangeToGrossMoneyAmount float,
    ExchangeToNetMoneyAmount float,
    ExchangeToPrice float
);

DROP TABLE IF EXISTS RejectionDialog;
CREATE TABLE RejectionDialog
(
    RejectDialogId SERIAL PRIMARY KEY,
    RejectId varchar(50),
    RejectCode varchar(50),
    RejectDescription varchar(50)
);

DROP TABLE IF EXISTS Comment;
-- CREATE TABLE Comment
-- (
--     id SERIAL PRIMARY KEY,
--     CommentText varchar(50),
--     CommentDateTime timestamptz,
--     CommentUserId varchar(50)
-- );

-- DROP TABLE IF EXISTS DistributionTransaction;
-- CREATE TABLE DistributionTransaction
-- (
--     DistributionTransactionId SERIAL PRIMARY KEY,
--     Aggregated boolean,
--     DistributionEventType varchar(50),
--     DistributionRate varchar(50),
--     DistributionRecordDate timestamptz,
--     EventId int,
--     ExcludedFromAggregation boolean,
--     OmnibusTradeTransmitted boolean
-- );

-- DROP TABLE IF EXISTS Event;
-- CREATE TABLE Event
-- (
--     EventRowId SERIAL PRIMARY KEY,
--     EventIdValue int
-- );



