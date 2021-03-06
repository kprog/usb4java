/*
 * Copyright 2013 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 * 
 * Based on libusb <http://www.libusb.org/>:  
 * 
 * Copyright 2001 Johannes Erdfelt <johannes@erdfelt.com>
 * Copyright 2007-2009 Daniel Drake <dsd@gentoo.org>
 * Copyright 2010-2012 Peter Stuge <peter@stuge.se>
 * Copyright 2008-2011 Nathan Hjelm <hjelmn@users.sourceforge.net>
 * Copyright 2009-2012 Pete Batard <pete@akeo.ie>
 * Copyright 2009-2012 Ludovic Rousseau <ludovic.rousseau@gmail.com>
 * Copyright 2010-2012 Michael Plante <michael.plante@gmail.com>
 * Copyright 2011-2012 Hans de Goede <hdegoede@redhat.com>
 * Copyright 2012 Martin Pieuchot <mpi@openbsd.org>
 * Copyright 2012-2013 Toby Gray <toby.gray@realvnc.com>
 */

package de.ailis.usb4java.libusb;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A structure representing the SuperSpeed USB Device Capability descriptor.
 * This descriptor is documented in section 9.6.2.2 of the USB 3.0 
 * specification.
 * 
 * All multiple-byte fields are represented in host-endian format.
 * 
 * @author Klaus Reimer (k@ailis.de)
 */
public final class SsUsbDeviceCapabilityDescriptor
{
    /** The native pointer to the descriptor structure. */
    private long ssUsbDeviceCapabilityDescriptorPointer;

    /**
     * Constructs a new SuperSpeed USB Device Capability descriptor which can 
     * be passed to the
     * {@link LibUsb#getSsUsbDeviceCapabilityDescriptor(Context, 
     * BosDevCapabilityDescriptor, SsUsbDeviceCapabilityDescriptor)} method.
     */
    public SsUsbDeviceCapabilityDescriptor()
    {
        // Empty
    }

    /**
     * Returns the native pointer.
     * 
     * @return The native pointer.
     */
    public long getPointer()
    {
        return this.ssUsbDeviceCapabilityDescriptorPointer;
    }

    /**
     * Returns the size of this descriptor (in bytes).
     * 
     * @return The descriptor size in bytes;
     */
    public native byte bLength();

    /**
     * Returns the descriptor type.
     * 
     * @return The descriptor type.
     */
    public native byte bDescriptorType();

    /**
     * Returns the device capability type.
     * 
     * @return The device capability type.
     */
    public native byte bDevCapabilityType();

    /**
     * Returns the bitmap of supported device level features. 
     * 
     * @return The supported device level features.
     */
    public native byte bmAttributes();
    
    /**
     * Returns the bitmap encoding of the speed supported by this device when 
     * operating in SuperSpeed mode.
     * 
     * @return The supported speed.
     */
    public native short wSpeedSupported();
    
    /**
     * Returns the lowest speed at which all the functionality supported by the 
     * device is available to the user.
     * 
     * @return The lowest speed.
     */
    public native byte bFunctionalitySupport();
    
    /**
     * Returns the U1 Device Exit Latency.
     * 
     * @return The U1 Device Exit Latency.
     */
    public native byte bU1DevExitLat();
    
    /**
     * Returns the U2 Device Exit Latency.
     * 
     * @return The U2 Device Exit Latency.
     */
    public native short bU2DevExitLat();

    /**
     * Returns a dump of this descriptor.
     * 
     * @return The descriptor dump.
     */
    public String dump()
    {
        return String.format("SuperSpeed USB Device Capability descriptor:%n"
            + "  bLength %18d%n"
            + "  bDescriptorType %10d%n"
            + "  bDevCapabilityType %7d%n"
            + "  bmAttributes %13s%n"
            + "  wSpeedSupported %10d%n"
            + "  bFunctionalitySupport %4d%n"
            + "  bU1DevExitLat %12d%n"
            + "  bU2DevExitLat %12d%n",
            bLength() & 0xff,
            bDescriptorType() & 0xff,
            bDevCapabilityType() & 0xff,
            String.format("0x%02x", bmAttributes() & 0xff),
            wSpeedSupported() & 0xffff,
            bFunctionalitySupport() & 0xff,
            bU1DevExitLat() & 0xff,
            bU2DevExitLat() & 0xffff);
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        final SsUsbDeviceCapabilityDescriptor other =
            (SsUsbDeviceCapabilityDescriptor) obj;
        return new EqualsBuilder()
            .append(bDescriptorType(), other.bDescriptorType())
            .append(bLength(), other.bLength())
            .append(bDevCapabilityType(), other.bDevCapabilityType())
            .append(bmAttributes(), other.bmAttributes())
            .append(wSpeedSupported(), other.wSpeedSupported())
            .append(bFunctionalitySupport(), other.bFunctionalitySupport())
            .append(bU1DevExitLat(), other.bU1DevExitLat())
            .append(bU2DevExitLat(), other.bU2DevExitLat())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
            .append(bLength())
            .append(bDescriptorType())
            .append(bDevCapabilityType())
            .append(bmAttributes())
            .append(wSpeedSupported())
            .append(bFunctionalitySupport())
            .append(bU1DevExitLat())
            .append(bU2DevExitLat())
            .toHashCode();
    }

    @Override
    public String toString()
    {
        return dump();
    }
}
