INSERT INTO ClientTransaction
    (
        ClearingFirmNumber
--         DealerFirmNumber,
--         AgentForFirm,
--         Bin,
--         FundId,
--         Cusip,
--         ExchangetoCusip,
--         NsccControlNumber,
--         NsccCorrectionIndicator,
--         CurrencyIndicator,
--         Price,
--         DistributionEventType,
--         DistributionRecordDate,
--         TradeDate,
--         SubmissionDate,
--         TransactionRecievedDate,
--         TransactionRecievedTime,
--         AnticipatedSettlementDate,
--         NsccSettlementOverrideReasonCode,
--         TransactionStatus,
--         WorkedCd,
--         PriceProtected,
--         ContingentDeferredSalesChargeLiquidationIndicator,
--         MiquidationIndicator529,
--         NavReasonCode,
--         SalesChargeRate,
--         DiscountCategory,
--         NsccRoaLoiValue,
--         ActualRoaValueSource,
--         MoiNumber,
--         ShortTermRedemptionFeeRate,
--         ShortTermRedemptionFeeShareAmount,
--         ShortTermRedemptionFeeMoneyAmount,
--         ContingentDeferredSalesChargeMoneyAmount,
--         MoneyMarketLiquidityFeeRate,
--         MoneyMarketLiquidtyFeeMoneyAmount,
--         TaxIdNumber,
--         TaxIdType,
--         Branch,
--         RepresentativeName,
--         RepresentativeNumber,
--         StateOfSale,
--         CountryCode,
--         SocialCode,
--         MoneyMarketLiquidityFeeRedemptionGateIndicator,
--         MoneyMarketAggregatedOrderIndicator,
--         DerivedBusinessProcessingGroup,
--         NsccTransactionType,
--         NsccTransactionCode,
--         NsccOriginalControlNumber,
--         NsccOriginalCorrectionIndicator,
--         NsccTestIndicator,
--         NsccAsofIndicator,
--         AsofReasonCode,
--         NsccCustomerName,
--         NsccFundAccountIndicator,
--         NsccBookPhysicalShareIndicator,
--         NsccRelatedTradeIndicator,
--         AssetTypeIndicator,
--         NsccFractionIndicator,
--         GrossNetSettlementIndicator,
--         NsccSecurityIssueType,
--         NsccFundParticipantNumberCd,
--         NsccOmnibusAccountIndicatorCd,
--         NsccProgramTransactionIndicatorCd,
--         NsccPeriodicFrequencyIndicatorCd,
--         OrderNumber,
--         NsccAcatsControlNumber,
--         NsccAcatsAssetsSequenceId,
--         FirmRoleInTransfer,
--         OriginatingFirmNumber,
--         OriginatingAgentForFirm,
--         OriginatingBIN,
--         OriginatingFundAccount,
--         OriginatingAccountOmnibusIndicator,
--         DestinationBIN,
--         DestinationFundAccount,
--         DestinationAccountOmnibusIndicator,
--         AsofPaymentDate,
--         NsccRegistrationStatusCode,
--         NsccRequestStatusCode
    )
VALUES
    (
        5
--          NOW(),
--         'agent',
--         NOW(),
--         'bin',
--         'anchh',
--         123,
--         'CountryCode',
--         'CurrencyIndicator',
--         123,
--         'EffectOnBalance',
--         'Fund_id',
--         'MoneyAmount',
--         'OmnibusTransaction_Id',
--         123,
--         'RepresentativeName',
--         123,
--         'SecurityId',
--         'SequenceId',
--         'ShareQuantity',
--         'StateOfSale',
--         NOW(),
--         'Symbol',
--         NOW(),
--         'TransactionCategory',
--         'TransactionSource',
--         'TransactionStatus',
--         'TransactionSubType',
--         'TransactionType',
--         'TransactionUserId'
    );

INSERT INTO TransactionDialog
    (
        TransmissionReceivedDateTime
    )
VALUES
    (
        NOW()
    );

INSERT INTO RejectionDialog
    (
        RejectId
    )
VALUES
    (
        6
    );







-- INSERT INTO Comment (CommentText, CommentDateTime, CommentUserId)
--     VALUES ('text', now(), 'IFDS');