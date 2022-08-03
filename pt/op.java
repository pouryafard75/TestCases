import org.robovm.rt.annotation.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("ImageIO")
@StronglyLinked /* </annotations> */
@Marshaler(/* <name> */CGImagePropertyGIF/* </name> */.Marshaler.class)
/* <visibility> */public/* </visibility> */ class /* <name> */ CGImagePropertyGIF/* </name> */
        extends /* <extends> */GlobalValueEnumeration<CFString>/* </extends> */
/* <implements> *//* </implements> */ {

    /* <constants> */
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF LoopCount = new CGImagePropertyGIF("LoopCount");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF DelayTime = new CGImagePropertyGIF("DelayTime");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF ImageColorMap = new CGImagePropertyGIF("ImageColorMap");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF HasGlobalColorMap = new CGImagePropertyGIF("HasGlobalColorMap");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF UnclampedDelayTime = new CGImagePropertyGIF("UnclampedDelayTime");
    /* </constants> */

    private static /* <name> */CGImagePropertyGIF/* </name> */[] values = new /* <name> */CGImagePropertyGIF/*
                                                                                                             * </name>
                                                                                                             */[] {
            /* <value_list> */LoopCount, DelayTime, ImageColorMap, HasGlobalColorMap, UnclampedDelayTime/*
                                                                                                         * </value_list>
                                                                                                         */ };

    /* <name> */ CGImagePropertyGIF/* </name> */ (String getterName) {
        super(Values.class, getterName);
        test();
    }

}