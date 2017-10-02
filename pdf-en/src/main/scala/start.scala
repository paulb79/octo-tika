import java.io._

import org.apache.tika.{metadata, parser}
import org.apache.tika.parser.pdf._
import org.apache.tika.metadata._
import org.apache.tika.parser._
import org.xml.sax._

object pdfParser extends ContentHandler {

  def characters(ch : Array[Char], start: Int, length: Int) {
    println(new String(ch))
  }

  def endDocument() {
  }

  def endElement(uri: String, localName: String, qName: String) {
  }

  def endPrefixMapping(prefix: String) {
  }

  def ignorableWhitespace(ch: Array[Char], start: Int, length: Int) {
  }

  def processingInstruction(target: String, data: String) {
  }

  def setDocumentLocator(locator: Locator) {
  }

  def skippedEntity(name: String) {
  }

  def startDocument() {
  }

  def startElement(uri: String, localName: String, qName: String, atts: Attributes) {
  }

  def startPrefixMapping(prefix: String, uri: String) {
  }

}

object reader extends App {


  // todo 1. invoke via command line args for path, filename and output
  // todo 2. support s3
  // todo 3. use api keys to run

  val folder = "/Users/paulb/Dropbox/Knowledge/"
  val file = "ButcherFarina_GoInPractice_MEAP_V09_ch1.pdf"

  val stream: InputStream = new FileInputStream(folder + file)
  val meta: Metadata = new metadata.Metadata
  val context: ParseContext = new parser.ParseContext
  val pdf: PDFParser = new PDFParser

  try {
    pdf.parse(stream, pdfParser, meta, context)
  } finally {
    stream.close()
  }

}
