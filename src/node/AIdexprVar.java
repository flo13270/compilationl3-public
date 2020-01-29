/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AIdexprVar extends PVar
{
    private TId _id_;
    private TLSbr _lSbr_;
    private PExpression _expression_;
    private TRSbr _rSbr_;

    public AIdexprVar()
    {
        // Constructor
    }

    public AIdexprVar(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TLSbr _lSbr_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TRSbr _rSbr_)
    {
        // Constructor
        setId(_id_);

        setLSbr(_lSbr_);

        setExpression(_expression_);

        setRSbr(_rSbr_);

    }

    @Override
    public Object clone()
    {
        return new AIdexprVar(
            cloneNode(this._id_),
            cloneNode(this._lSbr_),
            cloneNode(this._expression_),
            cloneNode(this._rSbr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdexprVar(this);
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

    public TLSbr getLSbr()
    {
        return this._lSbr_;
    }

    public void setLSbr(TLSbr node)
    {
        if(this._lSbr_ != null)
        {
            this._lSbr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lSbr_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    public TRSbr getRSbr()
    {
        return this._rSbr_;
    }

    public void setRSbr(TRSbr node)
    {
        if(this._rSbr_ != null)
        {
            this._rSbr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rSbr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._lSbr_)
            + toString(this._expression_)
            + toString(this._rSbr_);
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

        if(this._lSbr_ == child)
        {
            this._lSbr_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._rSbr_ == child)
        {
            this._rSbr_ = null;
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

        if(this._lSbr_ == oldChild)
        {
            setLSbr((TLSbr) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._rSbr_ == oldChild)
        {
            setRSbr((TRSbr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
