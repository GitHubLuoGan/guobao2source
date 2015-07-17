#!/bin/bash

#================================================================#
# Copyright (c) 2010-2011 Zipline Games, Inc.
# All Rights Reserved.
# http://getmoai.com
#================================================================#

#----------------------------------------------------------------#
# application and project names
#----------------------------------------------------------------#

	project_name="guobao"
	app_name="果宝特攻"
	pkg_name="guobao"
	
	DataEye_DC_APPID="9E26D765D4C16FF070237FB3BD8E259E"
	DataEye_DC_CHANNEL=$channel_name

	if [ x"$channel_name" == xuc ]; then
	    pkg_name=$pkg_name.uc
		jpush_appkey="2c28eb85dba33a81af22579f"
	fi
	
	if [ x"$channel_name" == xnd91 ]; then
	    pkg_name=$pkg_name"91"
		jpush_appkey="7ba9c9303a5f0b69af8bc7de"
	fi
	
	if [ x"$channel_name" == xqihoo360 ]; then
	    pkg_name=$pkg_name.qihoo360
		jpush_appkey="03ec23848fcef330b177b31a"
	fi
	
	if [ x"$channel_name" == xdownjoy ]; then
	    pkg_name=$pkg_name.downjoy
		jpush_appkey="d65f17654d64a414ba23a4e0"
	fi
	
	if [ x"$channel_name" == xxiaomi ]; then
	    pkg_name=$pkg_name.mi
		jpush_appkey="6a3a0e1d68cf55fb292f4883"
	fi
	
	if [ x"$channel_name" == xduoku ]; then
	    pkg_name=$pkg_name"DK"
		jpush_appkey="4c7dccab27167fac27edfb7f"
	fi
	
	if [ x"$channel_name" == xcmgc ]; then
	    pkg_name=$pkg_name.cmgc
	fi
	
	if [ x"$channel_name" == xtencent ]; then
	    pkg_name=$pkg_name.tencent
		jpush_appkey="1aa92636ba5f53f8357f9cf4"
	fi
	if [ x"$channel_name" == xwdj ]; then
	    pkg_name=$pkg_name.wdj
		jpush_appkey="1aa92636ba5f53f8357f9cf4"
	fi

	if [ x"$channel_name" == x4net_xiaomi ]; then
	    pkg_name=$pkg_name.mi
		jpush_appkey="1aa92636ba5f53f8357f9cf4"
	fi

	# if [ x"$channel_name" == xallsms ]; then
	#     pkg_name=$pkg_name.$channel_lua_name
	# fi
#----------------------------------------------------------------#
# talkingdata
#----------------------------------------------------------------#	
	talkingdata_appid="403A348F5DB558816ADB26509C3CFE6A"
	talkingdata_channelid=$channel_name
#----------------------------------------------------------------#
# version numbers
#----------------------------------------------------------------#

	version_code="3"
	version_name="1.1"

#----------------------------------------------------------------#
# space-delimited list of libraries (moai-supported) required 
# (this list is created by make-host.sh using command-line 
# information)
# available: facebook, tapjoy, crittercism, google-push, 
#            google-billing, miscellaneous (required by google-billing)
#----------------------------------------------------------------#
# domob sharesdk
	# require_module="fmod dataeye domob ulcdkey"

	if [ x"$channel_name" != x ]; then
	    require_module="$require_module $channel_name"
	fi

	requires=( $require_module )

	
#----------------------------------------------------------------#
# list of icon files
#----------------------------------------------------------------#

	icon_ldpi="res/icon-ldpi.png"
	icon_mdpi="res/icon-mdpi.png"
	icon_hdpi="res/icon-hdpi.png"
	icon_xhdpi="res/icon-xhdpi.png"

	if [ x"$channel_name" != x ]; then
	    icon_ldpi="res/icon-ldpi-"$channel_name.png
	    icon_mdpi="res/icon-mdpi-"$channel_name.png
	    icon_hdpi="res/icon-hdpi-"$channel_name.png
	    icon_xhdpi="res/icon-xhdpi-"$channel_name.png
	fi
		
#----------------------------------------------------------------#
# working directory in the assets directory of the application 
# bundle and a space-delimited list of lua files thereunder to run 
# when the application starts
#----------------------------------------------------------------#

	working_dir="lua"
	run=( "main.lua" )