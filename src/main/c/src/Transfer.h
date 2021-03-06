/*
 * Copyright (C) 2013 Klaus Reimer (k@ailis.de)
 * See COPYING file for copying conditions
 */

#ifndef USB4JAVA_TRANSFER_H
#define USB4JAVA_TRANSFER_H

#include "usb4java.h"

jobject wrapTransfer(JNIEnv*, struct libusb_transfer*);
struct libusb_transfer* unwrapTransfer(JNIEnv*, jobject);
void resetTransfer(JNIEnv*, jobject);

#endif
