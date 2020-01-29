/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AAffectationInstruction extends PInstruction
{
    private PAffectationInstruction _affectationInstruction_;

    public AAffectationInstruction()
    {
        // Constructor
    }

    public AAffectationInstruction(
        @SuppressWarnings("hiding") PAffectationInstruction _affectationInstruction_)
    {
        // Constructor
        setAffectationInstruction(_affectationInstruction_);

    }

    @Override
    public Object clone()
    {
        return new AAffectationInstruction(
            cloneNode(this._affectationInstruction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAffectationInstruction(this);
    }

    public PAffectationInstruction getAffectationInstruction()
    {
        return this._affectationInstruction_;
    }

    public void setAffectationInstruction(PAffectationInstruction node)
    {
        if(this._affectationInstruction_ != null)
        {
            this._affectationInstruction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._affectationInstruction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._affectationInstruction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._affectationInstruction_ == child)
        {
            this._affectationInstruction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._affectationInstruction_ == oldChild)
        {
            setAffectationInstruction((PAffectationInstruction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
