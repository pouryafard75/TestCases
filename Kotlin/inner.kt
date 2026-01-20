package leakcanary.internal

import leakcanary.GcRoot
import leakcanary.GcRoot.StickyClass
import leakcanary.HeapDumpMemoryStore
import leakcanary.HeapValue
import leakcanary.HeapValue.BooleanValue
import leakcanary.HeapValue.ByteValue
import leakcanary.HeapValue.CharValue
import leakcanary.HeapValue.DoubleValue
import leakcanary.HeapValue.FloatValue
import leakcanary.HeapValue.IntValue
import leakcanary.HeapValue.LongValue
import leakcanary.HeapValue.ObjectReference
import leakcanary.HeapValue.ShortValue
import leakcanary.HprofReader
import leakcanary.HprofWriter
import leakcanary.Record.HeapDumpRecord.GcRootRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.ClassDumpRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.InstanceDumpRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord
import leakcanary.Record.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump
import leakcanary.Record.LoadClassRecord
import leakcanary.Record.StringRecord
import okio.Buffer
import java.io.Closeable
import java.io.File
import java.util.UUID
import kotlin.reflect.KClass

class HprofWriterHelper constructor(
  private val writer: HprofWriter
) : Closeable {
  inner class InstanceAndClassDefinition {
    val field = LinkedHashMap<String, HeapValue>()
    val staticField = LinkedHashMap<String, HeapValue>()
  }

  inner class ClassDefinition {
    val staticField = LinkedHashMap<String, HeapValue>()
  }
}

fun File.dump(block: HprofWriterHelper.() -> Unit) {
  HprofWriterHelper(HprofWriter.open(this)).use(block)
}

fun HprofWriter.helper(block: HprofWriterHelper.() -> Unit) {
  HprofWriterHelper(this).use(block)
}
