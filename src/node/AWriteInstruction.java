/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AWriteInstruction extends PInstruction
{
    private PWriteInstruction _writeInstruction_;

    public AWriteInstruction()
    {
        // Constructor
    }

    public AWriteInstruction(
        @SuppressWarnings("hiding") PWriteInstruction _writeInstruction_)
    {
        // Constructor
        setWriteInstruction(_writeInstruction_);

    }

    @Override
    public Object clone()
    {
        return new AWriteInstruction(
            cloneNode(this._writeInstruction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWriteInstruction(this);
    }

    public PWriteInstruction getWriteInstruction()
    {
        return this._writeInstruction_;
    }

    public void setWriteInstruction(PWriteInstruction node)
    {
        if(this._writeInstruction_ != null)
        {
            this._writeInstruction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._writeInstruction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._writeInstruction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._writeInstruction_ == child)
        {
            this._writeInstruction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._writeInstruction_ == oldChild)
        {
            setWriteInstruction((PWriteInstruction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
