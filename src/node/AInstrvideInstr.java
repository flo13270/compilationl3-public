/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AInstrvideInstr extends PInstr
{
    private PInstrvide _instrvide_;

    public AInstrvideInstr()
    {
        // Constructor
    }

    public AInstrvideInstr(
        @SuppressWarnings("hiding") PInstrvide _instrvide_)
    {
        // Constructor
        setInstrvide(_instrvide_);

    }

    @Override
    public Object clone()
    {
        return new AInstrvideInstr(
            cloneNode(this._instrvide_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstrvideInstr(this);
    }

    public PInstrvide getInstrvide()
    {
        return this._instrvide_;
    }

    public void setInstrvide(PInstrvide node)
    {
        if(this._instrvide_ != null)
        {
            this._instrvide_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instrvide_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instrvide_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instrvide_ == child)
        {
            this._instrvide_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instrvide_ == oldChild)
        {
            setInstrvide((PInstrvide) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
