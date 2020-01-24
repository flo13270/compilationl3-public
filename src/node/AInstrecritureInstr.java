/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AInstrecritureInstr extends PInstr
{
    private PInstrecriture _instrecriture_;

    public AInstrecritureInstr()
    {
        // Constructor
    }

    public AInstrecritureInstr(
        @SuppressWarnings("hiding") PInstrecriture _instrecriture_)
    {
        // Constructor
        setInstrecriture(_instrecriture_);

    }

    @Override
    public Object clone()
    {
        return new AInstrecritureInstr(
            cloneNode(this._instrecriture_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstrecritureInstr(this);
    }

    public PInstrecriture getInstrecriture()
    {
        return this._instrecriture_;
    }

    public void setInstrecriture(PInstrecriture node)
    {
        if(this._instrecriture_ != null)
        {
            this._instrecriture_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instrecriture_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instrecriture_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instrecriture_ == child)
        {
            this._instrecriture_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instrecriture_ == oldChild)
        {
            setInstrecriture((PInstrecriture) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
