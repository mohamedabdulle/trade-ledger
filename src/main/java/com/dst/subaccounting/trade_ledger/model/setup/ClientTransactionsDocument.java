package com.dst.subaccounting.trade_ledger.model.setup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "clientTransactions")
public class ClientTransactionsDocument {

    @JsonAlias("_id")
    @Id
    private int id;

    @JsonAlias("maindocument")
    @Field("maindocument")
    private MainDocument mainDocument;

    @JsonAlias("distributiontransactions")
    @Field("distributiontransactions")
    private DistributionTransactions distributionTransactions;

    @JsonAlias("comments")
    @Field("comments")
    private Comments comments;
}
