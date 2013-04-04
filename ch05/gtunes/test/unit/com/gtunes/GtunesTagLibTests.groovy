package com.gtunes



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(GtunesTagLib)
class GtunesTagLibTests {

    void testRepeatTag() {
        // define a snippet of markup to evaluate
        def template = '<gt:repeat times="3">Number ${it}<br/></gt:repeat>'
        // evaluate the snippet
        def result = applyTemplate(template)
        // make sure the result contains what we expect
        def expected = 'Number 1<br/>Number 2<br/>Number 3<br/>'
        assert expected == result
    }

    void testRepeatTagWithAModel() {
        // define a snippet of markup to evaluate
        def template =
            '<gt:repeat times="${someNumber}">Number ${it}<br/></gt:repeat>'
        // evaluate the snippet
        def result = applyTemplate(template, [someNumber: 2])
        // make sure the result contains what we expect
        def expected = 'Number 1<br/>Number 2<br/>'
        assert expected == result

        // evaluate the snippet with a different model
        result = applyTemplate(template, [someNumber: 4])
        // make sure the result contains what we expect
        expected = 'Number 1<br/>Number 2<br/>Number 3<br/>Number 4<br/>'
        assert expected == result
    }

}
