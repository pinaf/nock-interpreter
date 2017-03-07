/**
 * Copyright 2017 Felipe Pina
 *
 * MIT License
 */
package nock.model;

/**
 * Cell.
 * @author Felipe Pina (felipe.pina@toptal.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface Cell extends Noun {

    /**
     * Cell's left side.
     * @return Noun
     */
    Noun left();

    /**
     * Cell's right side.
     * @return Noun
     */
    Noun right();

}
