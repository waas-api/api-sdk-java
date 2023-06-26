package com.waas.client;

import com.waas.client.dto.*;

/**
 * shop use this interface to request platform apis.
 * the default implement class will do the sign and verify sign things automatic.
 */
public interface iApiClient {

    /**
     * Coin related api for the merchant
     */
    coinListResponse coinList(coinListRequest request) throws Exception;

    /**
     * Return the new address to the merchant
     * The number of addresses obtained at a time is N (default 200), and merchants can request multiple times according to actual needs.
     * For accounts like EOS + memo mode, this interface only returns memo, with the interface: /address/coinAccount
     * Note: Platform eth, bnb_bsc (bsc main chain), ht_heco (heco main chain) are sharing the eth address, when requesting the address-related api please use eth as the parameter value of coin (coin=eth )
     */
    addressGetBatchResponse addressGetBatch(addressGetBatchRequest request) throws Exception;

    /**
     * After the merchant assigns the address to the user, it must notify the platform to update the address usage status through the "Status Synchronization Interface".
     */
    addressSyncStatusResponse addressSyncStatus(addressSyncStatusRequest request) throws Exception;

    /**
     * Query address usage status, address ownership.
     */
    addressListResponse addressList(addressListRequest request) throws Exception;

    /**
     * Address validity verification, currently only supports eth, trx, btc main chain address verification, and will continue to expand other main chain address verification in the future
     */
    addressVerifyAddressResponse addressVerifyAddress(addressVerifyAddressRequest request) throws Exception;

    /**
     * The merchant initial a on-chain withdrawal request will use this API. In order to complete the withdrawl request, merchant need to prepare the callback API for risk control callback. ( Detail please refer to the Risk Control callback -> The second review of the withdrawal order)
     */
    transferResponse transfer(transferRequest request) throws Exception;

}
