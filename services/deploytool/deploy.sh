#!/bin/bash

inet=$1
if [ "$inet" == "" ]; then
    inet=eth0
fi


profile=$2
if [ "$profile" == "" ]; then
    profile=test
fi

ver=$3
if [ "$ver" == "" ]; then
    ver=1.0.0
fi

jmx=$4
if [ "$jmx" == "" ]; then
    jmx=128m
fi

function addNewApp()
{
 allmake add app=$1 ver=$ver profile=$profile ports="$2" template=java inet=$inet jmx=$4
}

mkdir -p 01-provider 02-consumer
pushd 01-provider
mkdir -p 001 002 003 004 005 006
    pushd 001
        addNewApp vp-authority-manager-provider "9160 21010 31010" "" 64m
        addNewApp vp-sms-provider "9400 21020 31020" "" 64m
        addNewApp vp-common-config-provider "9790 21030 31030" "" 64m
        addNewApp vp-coupon-messaging-provider "9640 21040 31040" "" 64m
        addNewApp vp-upload-manager-provider "9970 22010 32010" "" 64m
        addNewApp vp-coupon-config-provider "9930 22030 32030" "" 64m
    popd
    pushd 002
        addNewApp vp-user-provider "9100 21060 31060" "" 96m
        addNewApp vp-coupon-report-provider "9600 21070 31070" "" 96m
        addNewApp vp-coupon-customer-reviews-provider "9910 21120 31120" "" 96m
    popd
    pushd 003
        addNewApp vp-finance-provider "9220 21080 31080" "" 96m
    popd
    pushd 004
        addNewApp vp-payment-config-provider "9340 21050 31050" "" 96m
        addNewApp vp-coupon-product-provider "9460 21090 31090" "" 96m
    popd
    pushd 005
	    addNewApp vp-payment-provider "9280 21100 31100" "" 96m
    popd
    pushd 006
        addNewApp vp-coupon-order-provider "9520 21110 31110" "" 96m
        addNewApp vp-order-provider "9525 21115 31115" "" 32m
        addNewApp vp-traffic-monetisation-provider "10010 23010 33010" "" 32m
	addNewApp vp-traffic-monetisation-adapter-provider "10030 23030 33030" "" 32m	
    popd

popd
pushd 02-consumer
mkdir -p 001 002 003 004
    pushd 001
        addNewApp vp-authority-manager-consumer "9190 21130 31130" "" 64m
        addNewApp vp-sms-consumer "9430 21140 31140 " "" 64m
        addNewApp vp-common-config-consumer "9870 21150 31150" "" 64m
        addNewApp vp-upload-manager-consumer "9980 22020 32020" "" 64m
        addNewApp vp-coupon-config-consumer "9940 22040 32040" "" 64m
    popd
    pushd 002
        addNewApp vp-payment-config-consumer "9370 21160 31160"  "" 64m
        addNewApp vp-payment-consumer "9310 21170 31170"  "" 128m
    popd
    pushd 003
        addNewApp vp-user-consumer "9130 21180 31180" "" 128m
        addNewApp vp-finance-consumer "9250 21190 31190" "" 128m
    popd
    pushd 004
        addNewApp vp-coupon-messaging-consumer "9670 21200 31200" "" 64m
        addNewApp vp-coupon-report-consumer "9610 21210 31210" "" 64m
        addNewApp vp-coupon-order-consumer "9550 21220 31220" "" 128m
        addNewApp vp-coupon-product-consumer "9490 21230 31230" "" 128m
        addNewApp vp-coupon-customer-reviews-consumer "9960 21240 31240" "" 64m
        addNewApp vp-order-consumer "9555 21225 31225" "" 64m
        addNewApp vp-monitor-consumer "9990 22210 32210" "" 64m
        addNewApp vp-traffic-monetisation-consumer "10020 23020 33020" "" 64m
        addNewApp vp-traffic-monetisation-adapter-consumer "10040 23040 33040" "" 64m
    popd
popd

