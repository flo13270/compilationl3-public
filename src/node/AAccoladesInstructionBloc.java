/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AAccoladesInstructionBloc extends PInstructionBloc
{
    private TLCbr _lCbr_;
    private PInstructionList _instructionList_;
    private TRCbr _rCbr_;

    public AAccoladesInstructionBloc()
    {
        // Constructor
    }

    public AAccoladesInstructionBloc(
        @SuppressWarnings("hiding") TLCbr _lCbr_,
        @SuppressWarnings("hiding") PInstructionList _instructionList_,
        @SuppressWarnings("hiding") TRCbr _rCbr_)
    {
        // Constructor
        setLCbr(_lCbr_);

        setInstructionList(_instructionList_);

        setRCbr(_rCbr_);

    }

    @Override
    public Object clone()
    {
        return new AAccoladesInstructionBloc(
            cloneNode(this._lCbr_),
            cloneNode(this._instructionList_),
            cloneNode(this._rCbr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAccoladesInstructionBloc(this);
    }

    public TLCbr getLCbr()
    {
        return this._lCbr_;
    }

    public void setLCbr(TLCbr node)
    {
        if(this._lCbr_ != null)
        {
            this._lCbr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lCbr_ = node;
    }

    public PInstructionList getInstructionList()
    {
        return this._instructionList_;
    }

    public void setInstructionList(PInstructionList node)
    {
        if(this._instructionList_ != null)
        {
            this._instructionList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instructionList_ = node;
    }

    public TRCbr getRCbr()
    {
        return this._rCbr_;
    }

    public void setRCbr(TRCbr node)
    {
        if(this._rCbr_ != null)
        {
            this._rCbr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rCbr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lCbr_)
            + toString(this._instructionList_)
            + toString(this._rCbr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lCbr_ == child)
        {
            this._lCbr_ = null;
            return;
        }

        if(this._instructionList_ == child)
        {
            this._instructionList_ = null;
            return;
        }

        if(this._rCbr_ == child)
        {
            this._rCbr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lCbr_ == oldChild)
        {
            setLCbr((TLCbr) newChild);
            return;
        }

        if(this._instructionList_ == oldChild)
        {
            setInstructionList((PInstructionList) newChild);
            return;
        }

        if(this._rCbr_ == oldChild)
        {
            setRCbr((TRCbr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
