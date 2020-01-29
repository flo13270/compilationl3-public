/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AExprlFunctionCall extends PFunctionCall
{
    private TId _id_;
    private TLBr _lBr_;
    private PExpressionList _expressionList_;
    private TRBr _rBr_;

    public AExprlFunctionCall()
    {
        // Constructor
    }

    public AExprlFunctionCall(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TLBr _lBr_,
        @SuppressWarnings("hiding") PExpressionList _expressionList_,
        @SuppressWarnings("hiding") TRBr _rBr_)
    {
        // Constructor
        setId(_id_);

        setLBr(_lBr_);

        setExpressionList(_expressionList_);

        setRBr(_rBr_);

    }

    @Override
    public Object clone()
    {
        return new AExprlFunctionCall(
            cloneNode(this._id_),
            cloneNode(this._lBr_),
            cloneNode(this._expressionList_),
            cloneNode(this._rBr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprlFunctionCall(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public TLBr getLBr()
    {
        return this._lBr_;
    }

    public void setLBr(TLBr node)
    {
        if(this._lBr_ != null)
        {
            this._lBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBr_ = node;
    }

    public PExpressionList getExpressionList()
    {
        return this._expressionList_;
    }

    public void setExpressionList(PExpressionList node)
    {
        if(this._expressionList_ != null)
        {
            this._expressionList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionList_ = node;
    }

    public TRBr getRBr()
    {
        return this._rBr_;
    }

    public void setRBr(TRBr node)
    {
        if(this._rBr_ != null)
        {
            this._rBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._lBr_)
            + toString(this._expressionList_)
            + toString(this._rBr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._lBr_ == child)
        {
            this._lBr_ = null;
            return;
        }

        if(this._expressionList_ == child)
        {
            this._expressionList_ = null;
            return;
        }

        if(this._rBr_ == child)
        {
            this._rBr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._lBr_ == oldChild)
        {
            setLBr((TLBr) newChild);
            return;
        }

        if(this._expressionList_ == oldChild)
        {
            setExpressionList((PExpressionList) newChild);
            return;
        }

        if(this._rBr_ == oldChild)
        {
            setRBr((TRBr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
