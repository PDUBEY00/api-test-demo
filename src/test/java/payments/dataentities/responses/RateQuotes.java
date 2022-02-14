package payments.dataentities.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateQuotes {

	@JsonProperty("settlement_cut_off_time")
	private String settlementCutOffTime;

	@JsonProperty("currency_pair")
	private String currencyPair;

	@JsonProperty("client_buy_currency")
	private String clientBuyCurrency;

	@JsonProperty("client_sell_currency")
	private String clientSellCurrency;

	@JsonProperty("client_buy_amount")
	private BigDecimal clientBuyAmount;

	@JsonProperty("fixed_side")
	private String fixedSide;

	@JsonProperty("client_buy_amount")
	public BigDecimal getClientBuyAmount() {
		return clientBuyAmount;
	}

}

