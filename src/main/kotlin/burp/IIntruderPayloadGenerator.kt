package burp

/*
 * @(#)IIntruderPayloadGenerator.java
 *
 * Copyright PortSwigger Ltd. All rights reserved.
 *
 * This code may be used to extend the functionality of Burp Suite Free Edition
 * and Burp Suite Professional, provided that this usage does not violate the
 * license terms for those products.
 */
/**
 * This interface is used for custom Intruder payload generators. Extensions
 * that have registered an
 * `IIntruderPayloadGeneratorFactory` must return a new instance of
 * this interface when required as part of a new Intruder attack.
 */
interface IIntruderPayloadGenerator {
    /**
     * This method is used by Burp to determine whether the payload generator is
     * able to provide any further payloads.
     *
     * @return Extensions should return
     * `false` when all the available payloads have been used up,
     * otherwise
     * `true`.
     */
    fun hasMorePayloads(): Boolean

    /**
     * This method is used by Burp to obtain the value of the next payload.
     *
     * @param baseValue The base value of the current payload position. This
     * value may be
     * `null` if the concept of a base value is not applicable (e.g.
     * in a battering ram attack).
     * @return The next payload to use in the attack.
     */
    fun getNextPayload(baseValue: ByteArray?): ByteArray

    /**
     * This method is used by Burp to reset the state of the payload generator
     * so that the next call to
     * `getNextPayload()` returns the first payload again. This
     * method will be invoked when an attack uses the same payload generator for
     * more than one payload position, for example in a sniper attack.
     */
    fun reset()
}
