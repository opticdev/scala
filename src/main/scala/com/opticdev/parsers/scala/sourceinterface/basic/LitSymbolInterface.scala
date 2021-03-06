package com.opticdev.parsers.scala.sourceinterface.basic

import com.opticdev.parsers.graph
import com.opticdev.parsers.graph.AstType
import com.opticdev.parsers.scala.scalaName
import com.opticdev.parsers.sourcegear.basic._
import play.api.libs.json.JsString

class LitSymbolInterface extends Literal {
  override val astType: graph.AstType = AstType("Lit.Symbol", scalaName)
  override val parser: SourceParser = (node, graph, raw, basicSourceInterface)=> {
    (node.properties \ "value").get.as[JsString]
  }
  override val mutator: SourceMutator = (node, graph, raw, newValue, parser, basicSourceInterface) => {
    generator(newValue, parser, basicSourceInterface)
  }
  override val generator: SourceGenerator = (newValue, sourceParser, basicSourceInterface) => {
    "'" + newValue.as[JsString].value
  }
}
