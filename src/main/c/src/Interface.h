/*
 * Copyright (C) 2013 Klaus Reimer (k@ailis.de)
 * See COPYING file for copying conditions
 */

#ifndef USB4JAVA_INTERFACE_H
#define USB4JAVA_INTERFACE_H

#include "usb4java.h"

extern jobject wrapInterface(JNIEnv *, const struct libusb_interface *);
extern jobjectArray wrapInterfaces(JNIEnv *, int, const struct libusb_interface *);

#endif
