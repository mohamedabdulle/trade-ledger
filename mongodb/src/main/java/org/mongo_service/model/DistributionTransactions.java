package org.mongo_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class DistributionTransactions {

	private boolean aggregated;
	private String distributionEventType;
	private String distributionRate;
	private String distributionRecordDate;
	private String[] eventId;
	private boolean excludedFromAggregation;
	private boolean omnibusTradeTransmitted;
}
