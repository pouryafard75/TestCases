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

    /* <constants> *//* </constants> */
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF LoopCount = new CGImagePropertyGIF("LoopCountKey");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF DelayTime;
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF ImageColorMap = new CGImagePropertyGIF("ImageColorMapKey", "as");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF HasGlobalColorMap = new CGImagePropertyGIF("HasGlobalColorMapKey");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final CGImagePropertyGIF UnclampedDelayTime = new CGImagePropertyGIF("UnclampedDelayTimeKey");

    private static CGImagePropertyGIF[] values = new CGImagePropertyGIF[] { LoopCount, DelayTime, ImageColorMap,
            HasGlobalColorMap, UnclampedDelayTime };
    private final LazyGlobalValue<CFString> lazyGlobalValue;
}