/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AIfIfInstruction extends PIfInstruction
{
    private TIf _if_;
    private PExpression _expression_;
    private TThen _then_;
    private PInstructionBloc _instructionBloc_;

    public AIfIfInstruction()
    {
        // Constructor
    }

    public AIfIfInstruction(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TThen _then_,
        @SuppressWarnings("hiding") PInstructionBloc _instructionBloc_)
    {
        // Constructor
        setIf(_if_);

        setExpression(_expression_);

        setThen(_then_);

        setInstructionBloc(_instructionBloc_);

    }

    @Override
    public Object clone()
    {
        return new AIfIfInstruction(
            cloneNode(this._if_),
            cloneNode(this._expression_),
            cloneNode(this._then_),
            cloneNode(this._instructionBloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfIfInstruction(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
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

    public TThen getThen()
    {
        return this._then_;
    }

    public void setThen(TThen node)
    {
        if(this._then_ != null)
        {
            this._then_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._then_ = node;
    }

    public PInstructionBloc getInstructionBloc()
    {
        return this._instructionBloc_;
    }

    public void setInstructionBloc(PInstructionBloc node)
    {
        if(this._instructionBloc_ != null)
        {
            this._instructionBloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instructionBloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._expression_)
            + toString(this._then_)
            + toString(this._instructionBloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._then_ == child)
        {
            this._then_ = null;
            return;
        }

        if(this._instructionBloc_ == child)
        {
            this._instructionBloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._then_ == oldChild)
        {
            setThen((TThen) newChild);
            return;
        }

        if(this._instructionBloc_ == oldChild)
        {
            setInstructionBloc((PInstructionBloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
