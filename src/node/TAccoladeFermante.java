/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TAccoladeFermante extends Token
{
    public TAccoladeFermante()
    {
        super.setText("}");
    }

    public TAccoladeFermante(int line, int pos)
    {
        super.setText("}");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAccoladeFermante(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAccoladeFermante(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAccoladeFermante text.");
    }
}
