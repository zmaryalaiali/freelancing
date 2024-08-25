package net.dkr.freelancing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PaymentResponse {

    @SerializedName("brand_color")
    @Expose
    private String brandColor;
    @SerializedName("brand_logo_url")
    @Expose
    private String brandLogoUrl;
    @SerializedName("charge_kind")
    @Expose
    private String chargeKind;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("collected_email")
    @Expose
    private Boolean collectedEmail;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("hosted_url")
    @Expose
    private String hostedUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("organization_name")
    @Expose
    private String organizationName;
    @SerializedName("payments")
    @Expose
    private List<Object> payments;
    @SerializedName("pricing")
    @Expose
    private Pricing pricing;
    @SerializedName("pricing_type")
    @Expose
    private String pricingType;
    @SerializedName("pwcb_only")
    @Expose
    private Boolean pwcbOnly;
    @SerializedName("redirects")
    @Expose
    private Redirects redirects;
    @SerializedName("support_email")
    @Expose
    private String supportEmail;
    @SerializedName("timeline")
    @Expose
    private List<Timeline> timeline;
    @SerializedName("web3_data")
    @Expose
    private Web3Data web3Data;
    @SerializedName("web3_retail_payment_metadata")
    @Expose
    private Web3RetailPaymentMetadata web3RetailPaymentMetadata;
    @SerializedName("web3_retail_payments_enabled")
    @Expose
    private Boolean web3RetailPaymentsEnabled;

    public String getBrandColor() {
        return brandColor;
    }

    public void setBrandColor(String brandColor) {
        this.brandColor = brandColor;
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    public void setBrandLogoUrl(String brandLogoUrl) {
        this.brandLogoUrl = brandLogoUrl;
    }

    public String getChargeKind() {
        return chargeKind;
    }

    public void setChargeKind(String chargeKind) {
        this.chargeKind = chargeKind;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getCollectedEmail() {
        return collectedEmail;
    }

    public void setCollectedEmail(Boolean collectedEmail) {
        this.collectedEmail = collectedEmail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getHostedUrl() {
        return hostedUrl;
    }

    public void setHostedUrl(String hostedUrl) {
        this.hostedUrl = hostedUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Object> getPayments() {
        return payments;
    }

    public void setPayments(List<Object> payments) {
        this.payments = payments;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public Boolean getPwcbOnly() {
        return pwcbOnly;
    }

    public void setPwcbOnly(Boolean pwcbOnly) {
        this.pwcbOnly = pwcbOnly;
    }

    public Redirects getRedirects() {
        return redirects;
    }

    public void setRedirects(Redirects redirects) {
        this.redirects = redirects;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public List<Timeline> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Timeline> timeline) {
        this.timeline = timeline;
    }

    public Web3Data getWeb3Data() {
        return web3Data;
    }

    public void setWeb3Data(Web3Data web3Data) {
        this.web3Data = web3Data;
    }

    public Web3RetailPaymentMetadata getWeb3RetailPaymentMetadata() {
        return web3RetailPaymentMetadata;
    }

    public void setWeb3RetailPaymentMetadata(Web3RetailPaymentMetadata web3RetailPaymentMetadata) {
        this.web3RetailPaymentMetadata = web3RetailPaymentMetadata;
    }

    public Boolean getWeb3RetailPaymentsEnabled() {
        return web3RetailPaymentsEnabled;
    }

    public void setWeb3RetailPaymentsEnabled(Boolean web3RetailPaymentsEnabled) {
        this.web3RetailPaymentsEnabled = web3RetailPaymentsEnabled;
    }

    public static class Web3Data {

        @SerializedName("transfer_intent")
        @Expose
        private Object transferIntent;
        @SerializedName("success_events")
        @Expose
        private List<Object> successEvents;
        @SerializedName("failure_events")
        @Expose
        private List<Object> failureEvents;
        @SerializedName("contract_addresses")
        @Expose
        private ContractAddresses contractAddresses;
        @SerializedName("settlement_currency_addresses")
        @Expose
        private SettlementCurrencyAddresses settlementCurrencyAddresses;
//        @SerializedName("subsidized_payments_chain_to_tokens")
//        @Expose
//        private SubsidizedPaymentsChainToTokens subsidizedPaymentsChainToTokens;
        @SerializedName("contract_caller_request_id")
        @Expose
        private String contractCallerRequestId;

        public Object getTransferIntent() {
            return transferIntent;
        }

        public void setTransferIntent(Object transferIntent) {
            this.transferIntent = transferIntent;
        }

        public List<Object> getSuccessEvents() {
            return successEvents;
        }

        public void setSuccessEvents(List<Object> successEvents) {
            this.successEvents = successEvents;
        }

        public List<Object> getFailureEvents() {
            return failureEvents;
        }

        public void setFailureEvents(List<Object> failureEvents) {
            this.failureEvents = failureEvents;
        }

        public ContractAddresses getContractAddresses() {
            return contractAddresses;
        }

        public void setContractAddresses(ContractAddresses contractAddresses) {
            this.contractAddresses = contractAddresses;
        }

        public SettlementCurrencyAddresses getSettlementCurrencyAddresses() {
            return settlementCurrencyAddresses;
        }

        public void setSettlementCurrencyAddresses(SettlementCurrencyAddresses settlementCurrencyAddresses) {
            this.settlementCurrencyAddresses = settlementCurrencyAddresses;
        }


        public String getContractCallerRequestId() {
            return contractCallerRequestId;
        }

        public void setContractCallerRequestId(String contractCallerRequestId) {
            this.contractCallerRequestId = contractCallerRequestId;
        }

    }

    public static class Web3RetailPaymentMetadata {

        @SerializedName("quote_id")
        @Expose
        private String quoteId;
        @SerializedName("source_amount")
        @Expose
        private SourceAmount sourceAmount;
        @SerializedName("exchange_rate_with_spread")
        @Expose
        private ExchangeRateWithSpread exchangeRateWithSpread;
        @SerializedName("exchange_rate_without_spread")
        @Expose
        private ExchangeRateWithoutSpread exchangeRateWithoutSpread;
        @SerializedName("max_retail_payment_value_usd")
        @Expose
        private Integer maxRetailPaymentValueUsd;
        @SerializedName("fees")
        @Expose
        private List<Object> fees;

        public String getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(String quoteId) {
            this.quoteId = quoteId;
        }

        public SourceAmount getSourceAmount() {
            return sourceAmount;
        }

        public void setSourceAmount(SourceAmount sourceAmount) {
            this.sourceAmount = sourceAmount;
        }

        public ExchangeRateWithSpread getExchangeRateWithSpread() {
            return exchangeRateWithSpread;
        }

        public void setExchangeRateWithSpread(ExchangeRateWithSpread exchangeRateWithSpread) {
            this.exchangeRateWithSpread = exchangeRateWithSpread;
        }

        public ExchangeRateWithoutSpread getExchangeRateWithoutSpread() {
            return exchangeRateWithoutSpread;
        }

        public void setExchangeRateWithoutSpread(ExchangeRateWithoutSpread exchangeRateWithoutSpread) {
            this.exchangeRateWithoutSpread = exchangeRateWithoutSpread;
        }

        public Integer getMaxRetailPaymentValueUsd() {
            return maxRetailPaymentValueUsd;
        }

        public void setMaxRetailPaymentValueUsd(Integer maxRetailPaymentValueUsd) {
            this.maxRetailPaymentValueUsd = maxRetailPaymentValueUsd;
        }

        public List<Object> getFees() {
            return fees;
        }

        public void setFees(List<Object> fees) {
            this.fees = fees;
        }

    }

    public static class _1 {

        @SerializedName("token_addresses")
        @Expose
        private List<String> tokenAddresses;

        public List<String> getTokenAddresses() {
            return tokenAddresses;
        }

        public void setTokenAddresses(List<String> tokenAddresses) {
            this.tokenAddresses = tokenAddresses;
        }

    }

    public static class _137 {

        @SerializedName("token_addresses")
        @Expose
        private List<String> tokenAddresses;

        public List<String> getTokenAddresses() {
            return tokenAddresses;
        }

        public void setTokenAddresses(List<String> tokenAddresses) {
            this.tokenAddresses = tokenAddresses;
        }

    }

    public static class _8453 {

        @SerializedName("token_addresses")
        @Expose
        private List<String> tokenAddresses;

        public List<String> getTokenAddresses() {
            return tokenAddresses;
        }

        public void setTokenAddresses(List<String> tokenAddresses) {
            this.tokenAddresses = tokenAddresses;
        }

    }


    public static class ContractAddresses {

        @SerializedName("1")
        @Expose
        private String _1;
        @SerializedName("137")
        @Expose
        private String _137;
        @SerializedName("8453")
        @Expose
        private String _8453;

        public String get1() {
            return _1;
        }

        public void set1(String _1) {
            this._1 = _1;
        }

        public String get137() {
            return _137;
        }

        public void set137(String _137) {
            this._137 = _137;
        }

        public String get8453() {
            return _8453;
        }

        public void set8453(String _8453) {
            this._8453 = _8453;
        }

    }

    public static class ExchangeRateWithSpread {

        @SerializedName("amount")
        @Expose
        private Object amount;
        @SerializedName("currency")
        @Expose
        private Object currency;

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

    }

    public static class ExchangeRateWithoutSpread {

        @SerializedName("amount")
        @Expose
        private Object amount;
        @SerializedName("currency")
        @Expose
        private Object currency;

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

    }

    public static class Local {

        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    public static class Metadata {

        @SerializedName("orderId")
        @Expose
        private String orderId;
        @SerializedName("userId")
        @Expose
        private String userId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

    }

    public static class Pricing {

        @SerializedName("local")
        @Expose
        private Local local;
        @SerializedName("settlement")
        @Expose
        private Settlement settlement;

        public Local getLocal() {
            return local;
        }

        public void setLocal(Local local) {
            this.local = local;
        }

        public Settlement getSettlement() {
            return settlement;
        }

        public void setSettlement(Settlement settlement) {
            this.settlement = settlement;
        }

    }

    public static class Redirects {

        @SerializedName("cancel_url")
        @Expose
        private String cancelUrl;
        @SerializedName("success_url")
        @Expose
        private String successUrl;
        @SerializedName("will_redirect_after_success")
        @Expose
        private Boolean willRedirectAfterSuccess;

        public String getCancelUrl() {
            return cancelUrl;
        }

        public void setCancelUrl(String cancelUrl) {
            this.cancelUrl = cancelUrl;
        }

        public String getSuccessUrl() {
            return successUrl;
        }

        public void setSuccessUrl(String successUrl) {
            this.successUrl = successUrl;
        }

        public Boolean getWillRedirectAfterSuccess() {
            return willRedirectAfterSuccess;
        }

        public void setWillRedirectAfterSuccess(Boolean willRedirectAfterSuccess) {
            this.willRedirectAfterSuccess = willRedirectAfterSuccess;
        }

    }

    public static class Settlement {

        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    public static class SettlementCurrencyAddresses {

        @SerializedName("1")
        @Expose
        private String _1;
        @SerializedName("137")
        @Expose
        private String _137;
        @SerializedName("8453")
        @Expose
        private String _8453;

        public String get1() {
            return _1;
        }

        public void set1(String _1) {
            this._1 = _1;
        }

        public String get137() {
            return _137;
        }

        public void set137(String _137) {
            this._137 = _137;
        }

        public String get8453() {
            return _8453;
        }

        public void set8453(String _8453) {
            this._8453 = _8453;
        }

    }

    public static class SourceAmount {

        @SerializedName("amount")
        @Expose
        private Object amount;
        @SerializedName("currency")
        @Expose
        private Object currency;

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

    }

//    public static class SubsidizedPaymentsChainToTokens {
//
//        @SerializedName("1")
//        @Expose
//
//        @SerializedName("137")
//        @Expose
//        private com.luilala.downloader._137 _137;
//        @SerializedName("8453")
//        @Expose
//        private com.luilala.downloader._8453 _8453;
//
//        public com.luilala.downloader._1 get1() {
//            return _1;
//        }
//
//        public void set1(com.luilala.downloader._1 _1) {
//            this._1 = _1;
//        }
//
//        public com.luilala.downloader._137 get137() {
//            return _137;
//        }
//
//        public void set137(com.luilala.downloader._137 _137) {
//            this._137 = _137;
//        }
//
//        public com.luilala.downloader._8453 get8453() {
//            return _8453;
//        }
//
//        public void set8453(com.luilala.downloader._8453 _8453) {
//            this._8453 = _8453;
//        }
//
//    }

    public static class Timeline {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("time")
        @Expose
        private String time;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    }

}



