/**
  * Write a tag function that takes three arguments: prefix, html, suffix
  * and evalues with a HTML code like: <div>Hello</div>
  * E.g:
  * tag("<div>", "<p>Hello world</p>", "</div>")
  * returns:
  * "<div><p>Hello world</p></div>"
  */

def tag(prefix: String, content: String, suffix: String): String = prefix+content+suffix

/**
  * Then write more specialized versions of it.
  */


val tag2 = tag _
val tag3 =  tag2 curried


val tagWithDiv = tag3("<div>")(_ : String)("</div>")
tagWithDiv("<p>Hello</p>")

val tagWithSpan = tag3("<span>")(_ : String)("</span>")

tagWithDiv("<p>Hello, World</p>")

tagWithSpan("<p>Hello, World</p>")


/**
  * Implement a partial function by implementing PartialFunction trait,
  * that is defined only for strings longer than five characters and returns a tuple of the string itself and its length
  * E.g.
  * ("softwaremill", 12)
  */

val pf : PartialFunction[String, Tuple2[String, Int]] = { case x if x.size > 5 => (x, x.size) }

List("dbroda","softwaremill").collect(pf)


/**
  * Reimplement the function above using case blocks
  */

val zipWithSize = ???

